package com.iftm.subscription.services;

import com.iftm.subscription.controllers.EmailController;
import com.iftm.subscription.controllers.UserController;
import com.iftm.subscription.data.vo.EmailVO;
import com.iftm.subscription.data.vo.UserVO;
import com.iftm.subscription.mapper.DozerMapper;
import com.iftm.subscription.models.Email;

import com.iftm.subscription.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class EmailService {

    @Autowired
    private EmailRepository repository;
    public List<EmailVO> findAll() {
        var emailDbList = repository.findAll();
        var emails = DozerMapper.parseListObject(emailDbList, EmailVO.class);
        emails.stream().forEach(email -> {
            try {
                email.add(linkTo(methodOn(EmailController.class).findById(email.getId()))
                        .withSelfRel()
                );
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
        return emails;
    }
    public List<EmailVO> dfindAll() {
        return DozerMapper.parseListObject(repository.findAll(), EmailVO.class);
    }
    public EmailVO findById(Long id) {
        return DozerMapper.parseObject(repository.findById(id).get(), EmailVO.class);
    }
    public EmailVO save(EmailVO emailVO) {
        if(verifyEmail(emailVO))
        {
            var email = repository.save(DozerMapper.parseObject(emailVO, Email.class));
            return DozerMapper.parseObject(email, EmailVO.class);
        }
        return null;
    }
    public EmailVO update(EmailVO emailVO) {
        var dbEmail = repository.findById(emailVO.getId());
        if(dbEmail.isPresent() && verifyEmail(emailVO)) {
            var email = repository.save(DozerMapper.parseObject(emailVO, Email.class));
            return DozerMapper.parseObject(email, EmailVO.class);
        }
        return null;
    }
    public String delete(Long id) {
        var dbEmail = repository.findById(id);
        if(dbEmail.isPresent()) {
            repository.deleteById(id);
            return "Email with id " + id + " has been deleted!";
        }
        return "ID " + id + " not found!";
    }
    private boolean verifyEmail(EmailVO emailVO) {
        if( !emailVO.getFrom().isBlank() && !emailVO.getFrom().isEmpty() &&
                !emailVO.getTo().isBlank() && !emailVO.getTo().isEmpty() &&
                !emailVO.getSubject().isBlank() && !emailVO.getSubject().isEmpty() &&
                !emailVO.getBody().isBlank() && !emailVO.getBody().isEmpty() ) {
            return true;
        }
        return false;
    }
}

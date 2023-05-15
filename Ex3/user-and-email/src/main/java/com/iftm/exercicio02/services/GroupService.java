package com.iftm.exercicio02.services;

import com.iftm.exercicio02.data.vo.GroupVO;
import com.iftm.exercicio02.mapper.DozerMapper;
import com.iftm.exercicio02.models.Group;
import com.iftm.exercicio02.repositories.GroupRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupService {

    private final GroupRepository groupRepository;
    private final DozerMapper dozerMapper;

    public GroupService(GroupRepository groupRepository, DozerMapper dozerMapper) {
        this.groupRepository = groupRepository;
        this.dozerMapper = dozerMapper;
    }

    public List<GroupVO> getAllGroups() {
        List<Group> groups = groupRepository.findAll();
        return groups.stream()
                .map(this::convertToGroupVO)
                .collect(Collectors.toList());
    }

    public GroupVO getGroupById(Long id) {
        Group group = groupRepository.findById(id).orElse(null);
        return convertToGroupVO(group);
    }

    public GroupVO createGroup(GroupVO groupVO) {
        Group group = convertToGroup(groupVO);
        Group createdGroup = groupRepository.save(group);
        return convertToGroupVO(createdGroup);
    }

    public GroupVO updateGroup(Long id, GroupVO groupVO) {
        Group existingGroup = groupRepository.findById(id).orElse(null);
        if (existingGroup != null) {
            Group updatedGroup = convertToGroup(groupVO);
            updatedGroup.setId(existingGroup.getId());
            Group savedGroup = groupRepository.save(updatedGroup);
            return convertToGroupVO(savedGroup);
        }
        return null;
    }

    public boolean deleteGroup(Long id) {
        Group existingGroup = groupRepository.findById(id).orElse(null);
        if (existingGroup != null) {
            groupRepository.delete(existingGroup);
            return true;
        }
        return false;
    }

    private GroupVO convertToGroupVO(Group group) {
        return DozerMapper.parseObject(group, GroupVO.class);
    }

    private Group convertToGroup(GroupVO groupVO) {
        return DozerMapper.parseObject(groupVO, Group.class);
    }
}

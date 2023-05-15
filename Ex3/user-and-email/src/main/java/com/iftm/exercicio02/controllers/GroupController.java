package com.iftm.exercicio02.controllers;

import com.iftm.exercicio02.data.vo.GroupVO;
import com.iftm.exercicio02.services.GroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    public ResponseEntity<List<GroupVO>> getAllGroups() {
        List<GroupVO> groups = groupService.getAllGroups();
        return new ResponseEntity<>(groups, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroupVO> getGroupById(@PathVariable("id") Long id) {
        GroupVO group = groupService.getGroupById(id);
        if (group != null) {
            return new ResponseEntity<>(group, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<GroupVO> createGroup(@RequestBody GroupVO groupVO) {
        GroupVO createdGroup = groupService.createGroup(groupVO);
        return new ResponseEntity<>(createdGroup, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GroupVO> updateGroup(@PathVariable("id") Long id, @RequestBody GroupVO groupVO) {
        GroupVO updatedGroup = groupService.updateGroup(id, groupVO);
        if (updatedGroup != null) {
            return new ResponseEntity<>(updatedGroup, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroup(@PathVariable("id") Long id) {
        boolean deleted = groupService.deleteGroup(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

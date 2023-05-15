package com.iftm.exercicio02.controllers;

import com.iftm.exercicio02.data.vo.EmailVO;
import com.iftm.exercicio02.data.vo.GroupVO;
import com.iftm.exercicio02.models.Group;
import com.iftm.exercicio02.models.User;
import com.iftm.exercicio02.services.GroupService;
import com.iftm.exercicio02.utils.MediaType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/groups")
@Tag(name = "Group", description = "Endpoint for managing groups.")
public class GroupController {

    @Autowired
    private GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }
    public GroupController( ) {
    }


    // UPDATE - HTTP PUT
    // Endpoint: http://localhost:8080/api/v1/groups
    @GetMapping
    @Operation(
            summary = "find list of groups", description = "find list of groups", tags = {"Group"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(mediaType = MediaType.APPLICATION_JSON,
                                            array = @ArraySchema(schema = @Schema(implementation = GroupVO.class))
                                    )
                            }
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public List<GroupVO> getAllGroups() {
        return groupService.findAll();
    }
    // READ - HTTP GET
    // Endpoint: http://localhost:8080/api/v1/group/ID
    @GetMapping("/{id}")
    @Operation(
            summary = "Find a group by ID.", description = "Find a group by ID.", tags = {"Group"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(mediaType = MediaType.APPLICATION_JSON,
                                            schema = @Schema(implementation = GroupVO.class)
                                    )
                            }
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public GroupVO findById(@PathVariable("id") Long id) {
        return groupService.findById(id);
    }

    // CREATE - HTTP POST
    // Endpoint: http://localhost:8080/api/v1/group/create
    @PostMapping
    @Operation(
            summary = "Create a group.", description = "Create a group.", tags = {"Group"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(
                                    schema = @Schema(implementation = GroupVO.class)
                            )
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public GroupVO save(@RequestBody GroupVO groupVO) {
        return groupService.save(groupVO);
    }

    // INSERT USERS - HTTP POST
    // Endpoint: http://localhost:8080/api/v1/group/insert-users
    @PostMapping("insert-users")
    @Operation(
            summary = "Insert a user in group.", description = "Insert a user in group.", tags = {"Group"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(
                                    schema = @Schema(implementation = GroupVO.class)
                            )
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public GroupVO insertUsers(@RequestBody GroupVO groupVO) {
        return groupService.insertUsers(groupVO);
    }

    // UPDATE - HTTP PUT
    // Endpoint: http://localhost:8080/api/v1/group/update
    @PutMapping
    @Operation(
            summary = "Update a group.", description = "Update a group.", tags = {"Group"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(
                                    schema = @Schema(implementation = GroupVO.class)
                            )
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public GroupVO update(@RequestBody GroupVO groupVO) {
        return groupService.update(groupVO);
    }

    // DELETE - HTTP DELETE
    // Endpoint: http://localhost:8080/api/v1/group/ID
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Deletes a Group by ID.", description = "Deletes a Group by ID.", tags = {"Group"},
            responses = {
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public String delete(@PathVariable("id") Long id) {
        return groupService.delete(id);
    }

    // DELETE - HTTP DELETE
    // Endpoint: http://localhost:8080/api/v1/group/{name}
    @GetMapping("/{name}")
    @Operation(
            summary = "Find a group by name.", description = "Find a group by name.", tags = {"Group"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(mediaType = MediaType.APPLICATION_JSON,
                                            schema = @Schema(implementation = GroupVO.class)
                                    )
                            }
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public List<User> findUsersByGroupId(Long groupId) {
        return groupService.findUsersByGroupId(groupId);
    }

    // DELETE - HTTP DELETE
    // Endpoint: http://localhost:8080/api/v1/group/name/{pwd}
    @GetMapping("/name/{pwd}")
    @Operation(
            summary = "Find a group by password users.", description = "Find a group by password users.", tags = {"Group"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(mediaType = MediaType.APPLICATION_JSON,
                                            schema = @Schema(implementation = GroupVO.class)
                                    )
                            }
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public List<Group> findByNameContaining(@PathVariable String pwd) {
        return groupService.findByNameContaining(pwd);
    }
}

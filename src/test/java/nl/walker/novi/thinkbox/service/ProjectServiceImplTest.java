package nl.walker.novi.thinkbox.service;

import nl.walker.novi.thinkbox.ThinkboxApplication;
import nl.walker.novi.thinkbox.domain.Project;
import nl.walker.novi.thinkbox.domain.User;
import nl.walker.novi.thinkbox.repository.ProjectRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;


@SpringBootTest()
@ContextConfiguration(classes={ThinkboxApplication.class})
public class ProjectServiceImplTest {

    @MockBean
    private ProjectService projectService;

    @MockBean
    private ProjectRepository projectRepository;


    @BeforeEach
    void setUp() {
//        User user1 = new User();
    }

    @Mock
    Project project;

    @Test
    public void getProjectByIdShouldReturnProject1() {
        User user1 = new User();
        Project project1 = new Project(1L, "title", false, user1);

        Mockito.when(projectService.getProjectById(1)).
                thenReturn(project1);

        assertEquals(1L, project.getId());

    }


//    @Test
//    public void saveProjectOK() {
//        User user1 = new User();
//        Project newProject = new Project(1L, "title", false, user1);
//
//        Mockito.when(projectService.saveProject(any(Project.class))).thenReturn(newProject);
//
//    }

}
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


@SpringBootTest()
@ContextConfiguration(classes={ThinkboxApplication.class})
public class ProjectServiceImplTest {

    @MockBean
    private ProjectService projectService;

    @MockBean
    private ProjectRepository projectRepository;

    @Mock
    Project project;

    @BeforeEach
    void setUp() {
        User user = new User();
        Project project = new Project(1L, "title", false, user);
    }

    @Test
    void getProjectById() {
        Mockito.when(projectService.getProjectById(1L))
                .thenReturn(project);
    }

}
package nl.walker.novi.thinkbox.service;

import nl.walker.novi.thinkbox.ThinkboxApplication;
import nl.walker.novi.thinkbox.domain.Project;
import nl.walker.novi.thinkbox.domain.User;
import nl.walker.novi.thinkbox.repository.ProjectRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import javax.swing.text.html.Option;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;


@SpringBootTest()
@ContextConfiguration(classes={ThinkboxApplication.class})
class ProjectServiceImplTest {

    @InjectMocks
    private ProjectServiceImpl projectService;

    @Mock
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
        Project p = new Project();
        p.setId(1L);

        Project project1 = new Project(1L, "title", false, user1);
        Mockito.when(projectRepository.existsById(anyLong())).thenReturn(true);
        Mockito.when(projectRepository.findById(anyLong())).thenReturn(Optional.of(p));

        Project project = projectService.getProjectById(1);

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
package nl.walker.novi.thinkbox.service;

import nl.walker.novi.thinkbox.ThinkboxApplication;
import nl.walker.novi.thinkbox.domain.Post;
import nl.walker.novi.thinkbox.domain.Project;
import nl.walker.novi.thinkbox.domain.User;
import nl.walker.novi.thinkbox.repository.ProjectRepository;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;


@SpringBootTest()
@ContextConfiguration(classes={ThinkboxApplication.class})
class ProjectServiceImplTest {

    @InjectMocks
    private ProjectServiceImpl projectService;

    @Mock
    private ProjectRepository projectRepository;

    @Mock
    Project project;

    @Test
    public void getProjectByIdShouldReturnProject1() {
        User user1 = new User();
        Project p = new Project();
        p.setId(1L);
        List<Post> posts = new ArrayList<>();

        Project project1 = new Project(1L, "title", false, user1, posts);
        Mockito.when(projectRepository.existsById(anyLong())).thenReturn(true);
        Mockito.when(projectRepository.findById(anyLong())).thenReturn(Optional.of(p));

        Project project = projectService.getProjectById(1);

        assertEquals(1L, project.getId());

    }

    @Test
    void deleteProjectTest(){
        Mockito.when(projectRepository.existsById(anyLong())).thenReturn(true);
        projectService.deleteProject(1L);
        Mockito.verify(projectRepository, times(1)).deleteById(1L);
    }

}
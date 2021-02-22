package nl.walker.novi.thinkbox.service;

import nl.walker.novi.thinkbox.ThinkboxApplication;
import nl.walker.novi.thinkbox.domain.Project;
import nl.walker.novi.thinkbox.domain.User;
import nl.walker.novi.thinkbox.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyLong;

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
    public void getProjectByIdShouldReturn1() {
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
//    public void deleteProject_returnsNull() {
//        Project p = new Project();
//        p.setId(1L);
//        Mockito.when(projectRepository.existsById(anyLong())).thenReturn(true);
//        Mockito.when(projectRepository.findById(anyLong())).thenReturn(Optional.of(p));
//
//        projectService.deleteProject((long)1);
//
//
//        assertEquals(null, p.getId(1L));
//    }

}

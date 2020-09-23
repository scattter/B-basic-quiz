package com.example.demo.service;

import com.example.demo.entity.EducationEntity;
import com.example.demo.entity.PersonEntity;
import com.example.demo.exception.UserIdNotExistException;
import com.example.demo.repository.EducationRepository;
import com.example.demo.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EducationServiceTest {

    @Mock
    EducationRepository educationRepository;
    @Mock
    PersonRepository personRepository;

    private EducationService educationService;

    private EducationEntity educationEntity;
    private PersonEntity personEntity;

    @BeforeEach
    void setUp() {
        educationService = new EducationService(educationRepository, personRepository);
        educationEntity = EducationEntity.builder()
                .title("Secondary")
                .year(2005)
                .description("Eos")
                .build();
        personEntity = PersonEntity.builder()
                .id(1)
                .name("KAMIL")
                .age(24)
                .avatar("https:")
                .description("Quasi.")
                .build();
    }

    @Nested
    class getEducationInfoById {
        @Nested
        class whenUserExists {
            @Test
            void shouldReturnFilledList() {
                List<EducationEntity> tmp = new ArrayList<>();
                tmp.add(educationEntity);
                long userId = 1;
                when(educationRepository.findAllByUserId(userId)).thenReturn(tmp);

                List<EducationEntity> result = educationService.getEducationInfoById(userId);

                assertThat(result).isEqualTo(tmp);
            }
        }

        @Nested
        class whenUserNotExists {
            @Test
            void shouldReturnEmptyList() {
                List<EducationEntity> tmp = new ArrayList<>();
                long userId = 2;
                when(educationRepository.findAllByUserId(userId)).thenReturn(tmp);

                List<EducationEntity> result = educationService.getEducationInfoById(userId);

                assertThat(result).isEqualTo(tmp);
            }
        }
    }

    @Nested
    class addEducationInfo {
        @Nested
        class whenUserExists {
            @Test
            void successAddEducationInfo() {
                List<PersonEntity> tmp = new ArrayList<>();
                tmp.add(personEntity);
                long userId = 1;
                when(personRepository.findAllById(userId)).thenReturn(tmp);
                educationEntity.setPersonEntity(personEntity);
                when(educationRepository.save(any())).thenReturn(educationEntity);

                EducationEntity info = educationService.addEducationInfo(userId, educationEntity);

                assertThat(info).isEqualTo(educationEntity);
            }
        }

        @Nested
        class whenUserNotExists {
            @Test
            void failAddEducationInfo() {
                List<PersonEntity> tmp = new ArrayList<>();
                long userId = 1;
                when(personRepository.findAllById(userId)).thenReturn(tmp);
                UserIdNotExistException userIdNotExistException = assertThrows(UserIdNotExistException.class,
                        () -> educationService.addEducationInfo(userId, educationEntity),
                        "Expected doThing() to throw, but it didn't");
                assertThat("this user isn't exist").isEqualTo(userIdNotExistException.getMessage());
            }
        }
    }
}
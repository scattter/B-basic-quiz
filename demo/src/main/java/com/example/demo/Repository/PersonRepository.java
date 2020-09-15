package com.example.demo.Repository;

import com.example.demo.Dto.PersonInfo;
import com.example.demo.Exception.UserIdNotExistException;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@Repository
public class PersonRepository {

    private Map<Long, PersonInfo> personInfoList = new HashMap<Long, PersonInfo>();

    public PersonRepository() {
        personInfoList.put((long) 1, PersonInfo.builder()
                .id((long) 1)
                .name("KAMIL")
                .age((long) 24)
                .avatar("https://inews.gtimg.com/newsapp_match/0/3581582328/0")
                .description("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Repellendus, non, dolorem, cumque distinctio magni quam expedita velit laborum sunt amet facere tempora ut fuga aliquam ad asperiores voluptatem dolorum! Quasi.")
                .build()
        );
    }

    public PersonInfo findById(Long id) {
        if (!personInfoList.containsKey(id)) {
            throw new UserIdNotExistException("userId not exist");
        }
        return personInfoList.get(id);
    }

    public void save(PersonInfo personInfo) {
        if (!personInfoList.containsKey(personInfo.getId())) {
            throw new UserIdNotExistException("userId not exist");
        }
        personInfoList.put(personInfo.getId(), personInfo);
    }
}

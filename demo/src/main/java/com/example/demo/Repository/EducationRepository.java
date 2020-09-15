package com.example.demo.Repository;

import com.example.demo.Dto.EducationInfo;
import com.example.demo.Dto.PersonInfo;
import com.example.demo.Exception.UserIdNotExistException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EducationRepository {

    private Map<Long, List<EducationInfo>> educationInfoList = new HashMap<Long, List<EducationInfo>>();

    public EducationRepository() {
        EducationInfo info1 = EducationInfo.builder()
                .userId((long) 1)
                .title("Secondary school specializing in artistic")
                .year((long) 2005)
                .description("Eos, explicabo, nam, tenetur et ab eius deserunt aspernatur ipsum ducimus quibusdam quis voluptatibus.")
                .build();
        EducationInfo info2 = EducationInfo.builder()
                .userId((long) 1)
                .title("First level graduation in Graphic Design")
                .year((long) 2009)
                .description("Aspernatur, mollitia, quos maxime eius suscipit sed beatae ducimus quaerat quibusdam perferendis? Iusto, quibusdam asperiores unde repellat.")
                .build();
        List<EducationInfo> lstEducationInfo = new ArrayList<EducationInfo>();
        lstEducationInfo.add(info1);
        lstEducationInfo.add(info2);

        educationInfoList.put(info1.getUserId(), lstEducationInfo);
    }

    public List<EducationInfo> getEducationInfoById(Long userId) {
        if (!educationInfoList.containsKey(userId)) {
            throw new UserIdNotExistException("userId not exist");
        }
        return educationInfoList.get(userId);
    }

    public void save(Long userId, EducationInfo educationInfo) {
        if (!educationInfoList.containsKey(userId)) {
            throw new UserIdNotExistException("userId not exist");
        }
        educationInfoList.forEach((id, lst) -> {
            if (id == userId) {
                lst.add(educationInfo);
            }
        });
    }
}

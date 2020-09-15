package com.example.demo.Repository;

import com.example.demo.Dto.EducationInfo;
import com.example.demo.Dto.PersonInfo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EducationRepository {

    private Map<Integer, List<EducationInfo>> educationInfoList = new HashMap<Integer, List<EducationInfo>>();

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

        educationInfoList.put(1, lstEducationInfo);
    }

    public List<EducationInfo> getEducationInfoById(Integer userId) {
        return educationInfoList.get(userId);
    }

    public void save(Integer userId,EducationInfo educationInfo) {
        educationInfoList.forEach((id, lst) -> {
            if (id==userId){
                lst.add(educationInfo);
            }
        });
    }
}

package com.project.freshman.mento.service;

import com.project.freshman.mento.model.Mento;
import com.project.freshman.mento.model.MentoCreateReq;
import com.project.freshman.mento.model.MentoLoginReq;
import com.project.freshman.mento.model.MentoUpdateReq;
import com.project.freshman.mento.repository.MentoRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MentoService {
    private final MentoRespository mentoRespository;

    public Mento signup(MentoCreateReq mentoCreateReq){
        Optional<Mento> data = mentoRespository.findByMentoEmail(mentoCreateReq.getMentoEmail());


        if(data.isPresent()){
            return null;
        }
        Mento mento = mentoRespository.save(Mento.builder()
                .mentoEmail(mentoCreateReq.getMentoEmail())
                .mentoPassword(mentoCreateReq.getMentoPassword())
                .mentoAddress(mentoCreateReq.getMentoAddress())
                .mentoCareer(mentoCreateReq.getMentoCareer())
                .Status(false)
                .authority(false)
                .mentoCreatedAt(LocalDate.now())
                .build());

        return Mento.builder()
                .idx(mento.getIdx())
                .mentoEmail(mento.getMentoEmail())
                .build();
    }

    public Boolean login(MentoLoginReq mentoLoginReq){
        Optional<Mento> data = mentoRespository.findByMentoEmail(mentoLoginReq.getMentoEmail());
        if (data.isPresent()){
            if (mentoLoginReq.getMentoPassword().equals(data.get().getMentoPassword())){
                return true;
            }
            return false;
        }
        return false;
    }
    public void read(){

    }
    public Mento update(MentoUpdateReq mentoUpdateReq){
        Optional<Mento> data = mentoRespository.findByMentoEmail(mentoUpdateReq.getMentoEmail());

        if(data.isEmpty()){
            return null;
        }
        Mento mento = data.get();
        mento = mentoRespository.save(Mento.builder()
                .idx(mento.getIdx())
                .mentoEmail(mentoUpdateReq.getMentoEmail())
                .mentoPassword(mentoUpdateReq.getMentoPassword())
                .mentoAddress(mentoUpdateReq.getMentoAddress())
                .mentoCareer(mentoUpdateReq.getMentoCareer())
                .Status(mento.getStatus())
                .authority(mento.getAuthority())
                .mentoCreatedAt(mento.getMentoCreatedAt())
                .mentoUpdatedAt(LocalDate.now())
                .build());

        return Mento.builder()
                .idx(mento.getIdx())
                .mentoEmail(mento.getMentoEmail())
                .build();
    }
    public Mento delete(Long idx){
        Optional<Mento> data = mentoRespository.findById(idx);

        if(data.isPresent()){
            String mentoEmail = data.get().getMentoEmail();
            mentoRespository.delete(Mento.builder()
                    .idx(idx).build());

            return Mento.builder()
                    .mentoEmail(mentoEmail)
                    .build();
        }
        return null;
    }
}

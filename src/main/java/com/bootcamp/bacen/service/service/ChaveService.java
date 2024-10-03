package com.bootcamp.bacen.service.service;


import com.bootcamp.bacen.service.dto.ChaveRequestDTO;
import com.bootcamp.bacen.service.dto.ChaveResponseDTO;
import com.bootcamp.bacen.service.exception.ChaveJaCadastradaException;
import com.bootcamp.bacen.service.exception.ChaveNaoLocalizadaException;
import com.bootcamp.bacen.service.model.Chave;
import com.bootcamp.bacen.service.repository.ChaveRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ChaveService {

    private final ChaveRepository chaveRepository;

    public ChaveResponseDTO criarChave(final ChaveRequestDTO chaveRequestDTO) {

        if(chaveRepository.existsByChave(chaveRequestDTO.getChave())) {
            throw new ChaveJaCadastradaException(String.format("A Chave: %s, já está cadastrada no bacen.", chaveRequestDTO.getChave()));
        }

        Chave chave = Chave.builder()
                .chave(chaveRequestDTO.getChave())
                .ativa(chaveRequestDTO.getAtiva())
                .build();

        chave = chaveRepository.save(chave);

        return ChaveResponseDTO.builder()
                .chave(chave.getChave())
                .ativa(chave.getAtiva())
                .build();
    }

    public ChaveResponseDTO buscarChaveByChave(final String chavePesquisada) {
        Chave chave = chaveRepository.findByChave(chavePesquisada)
                .orElseThrow(() -> new ChaveNaoLocalizadaException(String.format("A Chave: %s, não foi localizada no bacen.", chavePesquisada)));

        return ChaveResponseDTO.builder()
                .chave(chave.getChave())
                .ativa(chave.getAtiva())
                .build();
    }

}

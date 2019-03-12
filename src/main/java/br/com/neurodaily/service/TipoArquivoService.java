package br.com.neurodaily.service;

import br.com.neurodaily.model.domain.TipoArquivo;
import br.com.neurodaily.repository.TipoArquivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TipoArquivoService {

    @Autowired
    private TipoArquivoRepository tipoArquivoRepository;

    @Transactional
    public TipoArquivo salvar(TipoArquivo tipoArquivo) {
        TipoArquivo tipoArquivoBusca = buscartipoArquivoNome(tipoArquivo);
        if (tipoArquivoBusca != null) {
            tipoArquivo = tipoArquivoBusca;
        } else {
            tipoArquivo = tipoArquivoRepository.save(tipoArquivo);
        }
        return tipoArquivo;
    }

    private TipoArquivo buscartipoArquivoNome(TipoArquivo tipoArquivo) {
        TipoArquivo tipoArquivoBusca = null;
        if (tipoArquivo != null && tipoArquivo.getDescricao() != null) {
            tipoArquivoBusca = tipoArquivoRepository
                    .findByDescricao(tipoArquivo.getDescricao());
        }
        return tipoArquivoBusca;
    }

    private TipoArquivo buscartipoArquivoId(Long id) {
        TipoArquivo tipoArquivoBusca = tipoArquivoRepository.findById(id.longValue());
        return tipoArquivoBusca;
    }
}


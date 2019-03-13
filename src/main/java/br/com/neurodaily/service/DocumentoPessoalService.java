    package br.com.neurodaily.service;

    import br.com.neurodaily.model.domain.DocumentoPessoal;
    import br.com.neurodaily.model.domain.NotaAvaliacao;
    import br.com.neurodaily.repository.DocumentoPessoalRepository;
    import br.com.neurodaily.repository.NotaAvaliacaoRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;
    import org.springframework.transaction.annotation.Transactional;

    @Service
    public class DocumentoPessoalService {

        @Autowired
        private DocumentoPessoalRepository documentoPessoalRepository;


        @Transactional
        public DocumentoPessoal salvar(DocumentoPessoal documentoPessoal) {
            DocumentoPessoal documentoPessoalBusca = buscarDocumentoPessoal(documentoPessoal.getId());
            if (documentoPessoalBusca != null) {
                documentoPessoal = documentoPessoalBusca;
            } else {
                documentoPessoal = documentoPessoalRepository.save(documentoPessoal);
            }
            return documentoPessoal;
        }

        public DocumentoPessoal buscarDocumentoPessoal(Long id) {
            DocumentoPessoal documentoPessoalBusca = documentoPessoalRepository.findById(id.longValue());
            return documentoPessoalBusca;
        }

        public DocumentoPessoal buscarCpf(String cpf) {
            DocumentoPessoal documentoPessoalBusca = documentoPessoalRepository.findByCpf(cpf);
            return documentoPessoalBusca;
        }
    }


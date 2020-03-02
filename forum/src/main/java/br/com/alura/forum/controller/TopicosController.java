package br.com.alura.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.controller.dto.TopicoDTO;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.TopicoRepository;

@RestController
public class TopicosController {
	
	@Autowired
	private TopicoRepository topicoRepository;
	
	@RequestMapping("/topicos")
	public List<TopicoDTO> lista(String nomeCurso) {
		if(nomeCurso == null) {
			List<Topico> topicoss = topicoRepository.findAll();			
			return TopicoDTO.converter(topicoss);
		} else {
			List<Topico> topicoss = topicoRepository.findByCursoNome(nomeCurso);			
			return TopicoDTO.converter(topicoss);
		}
		
	}

}

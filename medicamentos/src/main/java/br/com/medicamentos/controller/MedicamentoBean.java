package br.com.medicamentos.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.medicamentos.model.Medicamento;
import br.com.medicamentos.service.MedicamentoService;
import br.com.medicamentos.utility.Message;
import br.com.medicamentos.utility.NegocioException;

@Named
@ViewScoped
public class MedicamentoBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private Medicamento medicamento;

	@Inject
	private MedicamentoService service;

	private List<Medicamento> medicamentos;

	@PostConstruct
	public void carregar() {
		medicamentos = service.todosOsMedicamentos();
	}

	public void adicionar() {
		try {
			service.salvar(medicamento);
			medicamento = new Medicamento();
			carregar();

			Message.info("Salvo com sucesso");

		} catch (NegocioException e) {
			Message.erro(e.getMessage());
		}
	}

	public void excluir() {
		try {
			service.remover(medicamento);
			carregar();

			Message.info(medicamento.getNome() + " foi removido");

		} catch (NegocioException e) {
			Message.erro(e.getMessage());
		}
	}

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public List<Medicamento> getMedicamentos() {
		return medicamentos;
	}

}

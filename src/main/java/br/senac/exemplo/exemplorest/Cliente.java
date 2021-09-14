package br.senac.exemplo.exemplorest;

//Classe de neg�cio de cliente
public class Cliente {

    //Atributos
    private Integer id;
    private String nome;
    private String cpf;

    //M�todos de acesso
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}

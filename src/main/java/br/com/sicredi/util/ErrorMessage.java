package br.com.sicredi.util;

public class ErrorMessage {
	
	private String dataAtual;
	private String mensagem;
	
	public ErrorMessage() {
	}
	
	public ErrorMessage(String timeStamp, String mensagem) {
		this.dataAtual = timeStamp;
		this.mensagem = mensagem;
	}
	
	public String getDataAtual() {
		return dataAtual;
	}
	public void setDataAtual(String dataAtual) {
		this.dataAtual = dataAtual;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}

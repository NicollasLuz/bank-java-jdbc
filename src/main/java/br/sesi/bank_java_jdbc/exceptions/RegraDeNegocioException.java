package br.sesi.bank_java_jdbc.exceptions;

public class RegraDeNegocioException extends RuntimeException {
        public RegraDeNegocioException(String mensagem){
                super(mensagem);
        }
}
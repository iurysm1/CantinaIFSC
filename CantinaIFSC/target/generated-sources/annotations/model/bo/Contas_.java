package model.bo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.bo.Compra;
import model.bo.Movimentocaixa;
import model.bo.Venda;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-04-01T20:12:33")
@StaticMetamodel(Contas.class)
public class Contas_ { 

    public static volatile SingularAttribute<Contas, Compra> compra;
    public static volatile SingularAttribute<Contas, String> observacao;
    public static volatile SingularAttribute<Contas, String> datahoraemissao;
    public static volatile SingularAttribute<Contas, Float> valorquitado;
    public static volatile SingularAttribute<Contas, Character> flagtipoconta;
    public static volatile SingularAttribute<Contas, Venda> venda;
    public static volatile SingularAttribute<Contas, Movimentocaixa> movimentacaocaixa;
    public static volatile SingularAttribute<Contas, String> dataquitacao;
    public static volatile SingularAttribute<Contas, Float> valoremitido;
    public static volatile SingularAttribute<Contas, Float> valoracrescimo;
    public static volatile SingularAttribute<Contas, String> datavencimento;
    public static volatile SingularAttribute<Contas, Integer> id;
    public static volatile SingularAttribute<Contas, Float> valordesconto;
    public static volatile SingularAttribute<Contas, String> status;

}
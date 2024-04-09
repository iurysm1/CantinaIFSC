package model.bo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.bo.Funcionario;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-04-01T20:12:33")
@StaticMetamodel(Caixa.class)
public class Caixa_ { 

    public static volatile SingularAttribute<Caixa, String> observacao;
    public static volatile SingularAttribute<Caixa, String> datahorafechamento;
    public static volatile SingularAttribute<Caixa, String> datahoraabertura;
    public static volatile SingularAttribute<Caixa, Integer> id;
    public static volatile SingularAttribute<Caixa, Funcionario> funcionario;
    public static volatile SingularAttribute<Caixa, Float> valorabertura;
    public static volatile SingularAttribute<Caixa, Float> valorfechamento;
    public static volatile SingularAttribute<Caixa, String> status;

}
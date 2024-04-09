package model.bo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.bo.Caixa;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-04-01T20:12:33")
@StaticMetamodel(Movimentocaixa.class)
public class Movimentocaixa_ { 

    public static volatile SingularAttribute<Movimentocaixa, String> observacao;
    public static volatile SingularAttribute<Movimentocaixa, Caixa> caixa;
    public static volatile SingularAttribute<Movimentocaixa, Character> flagtipomovimento;
    public static volatile SingularAttribute<Movimentocaixa, Float> valormovimento;
    public static volatile SingularAttribute<Movimentocaixa, Integer> id;
    public static volatile SingularAttribute<Movimentocaixa, String> datahoramovimento;
    public static volatile SingularAttribute<Movimentocaixa, String> status;

}
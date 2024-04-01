package service;

import java.util.List;

public interface InterfacecService<T> {
        public abstract void adicionar(T objeto);
        public abstract List<T> carregar();
        public abstract T carregar(int parPK);
        public abstract T carregar(String parString);
        public abstract void atualizar(T objeto);
        public abstract void remover(T objeto);
}

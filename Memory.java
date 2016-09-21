import java.util.Arrays;

public class Memory {

    private static final int SEM_VALOR = -1;

    private final int memoria[];
    private final int tamanho;
    private int quantidadeElementos;

    public Memory(
            int tamanho) {
        memoria = new int[tamanho];
        this.tamanho = tamanho;
        quantidadeElementos = 0;

        // inicializa valores
        for (int i = 0; i < tamanho; i++) {
            memoria[i] = SEM_VALOR;
        }

        System.out.println("Mem�ria iniciada! Tamanho: " + this.dimension());
    }

    public int size() {
        return quantidadeElementos;
    }

    public int dimension() {
        return tamanho;
    }

    public int getElement(int pos) {
        return memoria[pos];
    }

    public void setElement(int pos, int val) {
        System.out.println("Colocando o valor " + val + " na posi��o " + pos);
        if (pos < tamanho) {
            if (memoria[pos] == SEM_VALOR) {
                quantidadeElementos++;
            }
            System.out.println("Valor " + memoria[pos] + " substitu�do por " + val + " na posi��o " + pos);
            memoria[pos] = val;
        } else {
            System.err
                    .println("Memory.setElement(pos=" + pos + ", val=" + val + ") -> Posi��o [" + pos + "] inv�lida!");
        }
    }

    public boolean isEmpty() {
        return quantidadeElementos == 0;
    }

    public boolean isFull() {
        return quantidadeElementos == tamanho;
    }

    public void insert(int val) {
        System.out.println("Adicionando -> " + val);
        if (!isFull()) {
            for (int i = 0; i < memoria.length; i++) {
                if (memoria[i] == SEM_VALOR) {
                    memoria[i] = val;
                    quantidadeElementos++;
                    break;
                }
            }
        } else {
            System.err.println("Memory.insert(val=" + val + ") -> Mem�ria cheia!");
        }
    }

    public int delete() {
        int valor = SEM_VALOR;
        System.out.println("Excluindo �ltimo elemento...");
        if (!isEmpty()) {
            for (int i = memoria.length - 1; i >= 0; i--) {
                if (memoria[i] != SEM_VALOR) {
                    valor = memoria[i];
                    memoria[i] = SEM_VALOR;
                    quantidadeElementos--;
                    break;
                }
            }
        } else {
            System.err.println("Memory.delete() -> Mem�ria vazia!");
        }

        return valor;
    }

    public int search(int val) {
        System.out.println("Buscando o valor -> " + val);
        for (int i = 0; i < memoria.length; i++) {
            if (memoria[i] == val) {
                System.out.println(val + " encontrado! Posi��o: " + i);
                return i;
            }
        }
        System.err.println(val + " n�o encontrado!");
        return SEM_VALOR;
    }

    public String toString() {
        return Arrays.toString(memoria).replaceAll("-1", "");
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Memory memoria = new Memory(3);
        memoria.insert(10);
        memoria.insert(20);

        System.out.println("Quantidade de elementos: " + memoria.size());
        System.out.println("Elementos na mem�ria: " + memoria);
        System.out.println("Est� vazia? " + memoria.isEmpty());
        System.out.println("Est� cheia? " + memoria.isFull());

        memoria.delete();
        System.out.println("Quantidade de elementos: " + memoria.size());
        System.out.println("Elementos na mem�ria: " + memoria);

        memoria.delete();
        System.out.println("Quantidade de elementos: " + memoria.size());
        System.out.println("Elementos na mem�ria: " + memoria);
        System.out.println("Est� vazia? " + memoria.isEmpty());
        System.out.println("Est� cheia? " + memoria.isFull());

        System.out.println("Deletando elemento inexistente... (erro esperado)");
        memoria.delete();
        System.out.println("Elementos na mem�ria: " + memoria);
        System.out.println("Est� vazia? " + memoria.isEmpty());

        System.out.println("Adicionando 3 elementos...");
        memoria.insert(50);
        memoria.insert(60);
        memoria.insert(70);
        System.out.println("Quantidade de elementos: " + memoria.size());
        System.out.println("Elementos na mem�ria: " + memoria);
        System.out.println("Est� vazia? " + memoria.isEmpty());
        System.out.println("Est� cheia? " + memoria.isFull());

        System.out.println("Adicionando elemento em mem�ria cheia... (erro esperado)");
        memoria.insert(80);
        System.out.println("Elementos na mem�ria: " + memoria);
        System.out.println("Est� cheia? " + memoria.isFull());
        
        System.out.println("Buscando valor inexistente... (erro esperado)");
        memoria.search(100);
        
        System.out.println("Buscando valor existente");
        int pos = memoria.search(60);
        memoria.setElement(pos, 90);
        
    }

}

package br.com.idtrust.dev.junior;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InterviewDev {

        private static final Set<Recebivel> RECEBIVEIS;

        public static void main(String[] args) throws Exception {

                System.out.println("Faça os exercícios abaixo usando os dados pré-criados na variável `RECEBIVEIS`.");
                System.out.println("Peço que prepare a resolução logo abaixo de cada enunciado.");
                System.out.println("");

                System.out.println("1 - Print a soma agrupando as mesmas datas de vencimentos");

                Recebivel recebiveis = new Recebivel();
                Set<LocalDate> datasRepetidas = new HashSet<>();
                Set<BigDecimal> somaDosValores = new HashSet<>();
                Set<BigDecimal> valoresVencidos = new HashSet<>();

                LocalDate data = LocalDate.parse("2023-07-25");
                LocalDate InterseccaoData = LocalDate.parse("2023-07-25");
                LocalDate fomarmataData = LocalDate.parse("2023-07-25");

                BigDecimal soma = new BigDecimal("0");

                for (Recebivel r : RECEBIVEIS) {
                        if (r.dataVencimento.isBefore(LocalDate.now())) {
                                valoresVencidos.add(r.valor);
                        }
                        for (Recebivel e : RECEBIVEIS) {
                                if (r.codigo != e.codigo && r.dataVencimento.equals(e.dataVencimento)) {
                                        datasRepetidas.add(r.dataVencimento);
                                        soma = e.valor.add(r.valor);
                                        somaDosValores.add(soma);
                                }
                        }
                        if (r.dataVencimento.equals(data)) {
                                r.converterParaReal(r.valor);
                        }

                        if (r.dataVencimento.equals(InterseccaoData)) {
                                r.prazoEmDias(r.dataEmissao, r.dataVencimento);
                        }

                        if (r.dataVencimento.equals(fomarmataData)) {
                                r.formataDatas(r.dataVencimento);
                        }

                }

                System.out.println("valor da soma " + somaDosValores);

                System.out.println("As datas repetidas são: " + datasRepetidas);

                System.out.println();

                System.out.println("2 - Print a soma dos recebiveis ja vencidos");

                System.out.println();

                recebiveis.somaDatasVencidas(valoresVencidos);

                System.out.println();

                System.out.println("3 - Formate para moeda Real o valor do recebivel com vencimento 25/07/2023");

                System.out.println();

                System.out.println(
                                "4 - Print o prazo em dias entre emissao e vencimento do recebivel com vencimento 12/10/2023");

                System.out.println();

                System.out.println("5 - Print a concatenação de todos os campos do recebivel separando por ;");

                System.out.println();

                System.out.println(RECEBIVEIS);

                System.out.println();

                System.out.println("6 - Formate a data 2023-06-25 do recebivel para o formato dd/MM/yyyy");

                System.out.println();

                System.out.println("Exercício extra:");
                System.out.println(
                                "7 - Dado uma lista da variável `valores` abaixo, acrescente um novo valor de acordo com as regras a seguir:");
                System.out.println(" - R$5,90 para valores menor e igual que R$100,00");
                System.out.println(" - R$15,00 para valores menor que R$20,00");
                System.out.println(" - R$4,33 para valores maior que R$100,00");
                System.out.println(" - R$2,10 para valores maior que R$200,00");
                System.out.println(" - R$3,55 para valores igual que R$150,00");
                System.out.println(
                                " Print o novo resultado na saída da condição de validação e no final print a soma de todos os novos valores da lista");
                List<BigDecimal> valores = Arrays.asList(new BigDecimal("88.88"), new BigDecimal("17.01"),
                                new BigDecimal("20.00"), new BigDecimal("150.00"), new BigDecimal("124.21"),
                                new BigDecimal("247.09"),
                                new BigDecimal("100.00"), new BigDecimal("4.99"));

                System.out.println();

                BigDecimal valoresDaLista1 = new BigDecimal("100.00");
                BigDecimal valoresDaLista2 = new BigDecimal("20.00");
                BigDecimal valoresDaLista3 = new BigDecimal("200.00");
                BigDecimal valoresDaLista4 = new BigDecimal("150.00");
                BigDecimal total = new BigDecimal("0");

                List<BigDecimal> lista = new ArrayList<BigDecimal>();

                for (int i = 0; i < valores.size(); i++) {
                        if (valores.get(i).compareTo(valoresDaLista1) <= 0) {
                                // System.out.println("valor menor e igual à 100");
                                // System.out.println(valores.get(i));
                                lista.add(new BigDecimal("5.90"));
                        }
                        if (valores.get(i).compareTo(valoresDaLista2) < 0) {
                                // System.out.println("valor menor que 20");
                                // System.out.println(valores.get(i));
                                lista.add(new BigDecimal("15.00"));
                        }
                        if (valores.get(i).compareTo(valoresDaLista1) > 0) {
                                // System.out.println("valor maior que 100");
                                // System.out.println(valores.get(i));
                                lista.add(new BigDecimal("4.33"));
                        }
                        if (valores.get(i).compareTo(valoresDaLista3) > 0) {
                                // System.out.println("valor maior que 200");
                                // System.out.println(valores.get(i));
                                lista.add(new BigDecimal("2.10"));
                        }
                        if (valores.get(i).equals(valoresDaLista4)) {
                                // System.out.println("valor igual à 150");
                                // System.out.println(valores.get(i));
                                lista.add(new BigDecimal("3.55"));
                        }

                }

                for (BigDecimal l : lista) {
                        total = total.add(l);
                }

                System.out.println(total + " Soma dos novos valores");

                System.out.println();

                System.out.println("Boa Sorte!");

                System.out.println("---------------------------------------------------");

        }

        static {
                Set<Recebivel> rs = new HashSet<>();
                rs.add(Recebivel.create("1H01R6HA1", LocalDate.parse("2023-05-02"), LocalDate.parse("2023-08-09"),
                                new BigDecimal("146.99")));
                rs.add(Recebivel.create("1H01R6HB1", LocalDate.parse("2023-05-02"), LocalDate.parse("2023-05-08"),
                                new BigDecimal("592.18")));
                rs.add(Recebivel.create("1H01R6HC1", LocalDate.parse("2023-05-03"), LocalDate.parse("2023-06-28"),
                                new BigDecimal("98.20")));
                rs.add(Recebivel.create("1H01R6HD1", LocalDate.parse("2023-05-06"), LocalDate.parse("2023-09-19"),
                                new BigDecimal("726.01")));
                rs.add(Recebivel.create("1H01R6HE1", LocalDate.parse("2023-05-02"), LocalDate.parse("2023-05-08"),
                                new BigDecimal("81.88")));
                rs.add(Recebivel.create("1H01R6HF1", LocalDate.parse("2023-05-03"), LocalDate.parse("2023-07-15"),
                                new BigDecimal("221.34")));
                rs.add(Recebivel.create("1H01R6HG1", LocalDate.parse("2023-05-02"), LocalDate.parse("2023-07-25"),
                                new BigDecimal("711.98")));
                rs.add(Recebivel.create("1H01R6HH1", LocalDate.parse("2023-05-05"), LocalDate.parse("2023-10-10"),
                                new BigDecimal("100.27")));
                rs.add(Recebivel.create("1H01R6HI1", LocalDate.parse("2023-05-02"), LocalDate.parse("2023-10-12"),
                                new BigDecimal("3021.83")));
                rs.add(Recebivel.create("1H01R6HJ1", LocalDate.parse("2023-05-03"), LocalDate.parse("2023-09-19"),
                                new BigDecimal("1930.76")));

                RECEBIVEIS = Collections.unmodifiableSet(rs);
        }

        public static class Recebivel {

                public static Recebivel create(String codigo, LocalDate dataEmissao, LocalDate dataVencimento,
                                BigDecimal valor) {
                        Recebivel r = new Recebivel();
                        r.codigo = codigo;
                        r.dataEmissao = dataEmissao;
                        r.dataVencimento = dataVencimento;
                        r.valor = valor;
                        return r;
                }

                public void somaDatasVencidas(Set<BigDecimal> valores) {
                        BigDecimal sum = new BigDecimal("0");
                        for (BigDecimal v : valores) {
                                sum = sum.add(v);
                        }

                        System.out.println("À soma dos valores vencidos é " + sum);

                }

                public void converterParaReal(BigDecimal valor) {
                        DecimalFormat decFormat = new DecimalFormat("'R$ ' 0.##");
                        System.out.println("Número formatado para Real = " + decFormat.format(valor));
                }

                public void prazoEmDias(LocalDate emissao, LocalDate vencimento) {

                        LocalDate mesInicio = LocalDate.of(emissao.getYear(), emissao.getMonth(),
                                        emissao.getDayOfMonth());
                        LocalDate mesFinal = LocalDate.of(vencimento.getYear(), vencimento.getMonth(),
                                        vencimento.getDayOfMonth());
                        long InterseccaoDias = ChronoUnit.DAYS.between(mesInicio, mesFinal);

                        System.out.println(InterseccaoDias + " dias entre as datas");
                }

                public void formataDatas(LocalDate data) {

                        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                        String dataFormatada = data.format(formatoData);

                        System.out.println("Novo formato do recebivel: " + dataFormatada);
                }

                @Override
                public String toString() {
                        return "{" +
                                        "codigo " + codigo + ";" +
                                        " dataEmissao " + dataEmissao + ";" +
                                        " dataVencimento " + dataVencimento + ";" +
                                        " valor " + valor +
                                        "}";
                }

                private String codigo;
                private LocalDate dataEmissao;
                private LocalDate dataVencimento;
                private BigDecimal valor;

        }

}

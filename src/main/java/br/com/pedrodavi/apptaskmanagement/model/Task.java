package br.com.pedrodavi.apptaskmanagement.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String titulo;

    @Column
    private String descricao;

    @Column
    private String responsavel;

    @Column
    private String prioridade;

    @Column
    private String data;

    @Column
    private String status;

}

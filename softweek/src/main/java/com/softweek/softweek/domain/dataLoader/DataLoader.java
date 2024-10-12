package com.softweek.softweek.domain.dataLoader;

import com.softweek.softweek.domain.repository.Categoriarepository;
import com.softweek.softweek.domain.repository.ProdutoRepository;
import com.softweek.softweek.domain.repository.SubcategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.SQLException;

@Component
public class DataLoader {

    @Autowired
    private Categoriarepository categoriarepository;

    @Autowired
    private SubcategoriaRepository subcategoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Bean
    public CommandLineRunner carregarDados(DataSource dataSource) {
        return args -> {
            try {
                if (categoriarepository.count() == 0) {
                    ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("insertCat.sql"));
                }

                if (subcategoriaRepository.count() == 0) {
                    ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("insertSubcat.sql"));
                }

                if (produtoRepository.count() == 0) {
                    ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("insertProd.sql"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        };
    }
}

package com.hunt.otziv.services;

import com.hunt.otziv.dto.CompanyDto;
import com.hunt.otziv.model.Category;
import com.hunt.otziv.model.Company;
import com.hunt.otziv.repository.CategoryRepository;
import com.hunt.otziv.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService{

    private final CompanyRepository companyRepository;
    private final CategoryRepository categoryRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository, CategoryRepository categoryRepository) {
        this.companyRepository = companyRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CompanyDto> findAll() {
        /*Мы запрашиваем из базы все компании, создаем из них поток, каждый элемент
        * которого преобразуем из company в companyDto используя ccылку :: на метод toDto и далее
        * сохраняя все это в коллекцию при помощи collect */
        return companyRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private CompanyDto toDto(Company company){
        return CompanyDto.builder()
                .id(company.getId())
                .name(company.getName())
                .email(company.getEmail())
                .numberPhone(company.getNumberPhone())
                .link(company.getLink())
                .categorys(company.getCategory())
                .isActive(company.isActive())
                .build();
    }

    @Override
    public void saveCompany(CompanyDto companyDto) {
            Company company = Company.builder()
                    .name(companyDto.getName())
                    .email(companyDto.getEmail())
                    .numberPhone(companyDto.getNumberPhone().replaceFirst("8", "+7"))
                    .link(companyDto.getLink())
                    .category(companyDto.getCategorys())
                    .isActive(companyDto.isActive())
                    .build();

            companyRepository.save(company);

    }

    @Override
    public CompanyDto findById(Long id) {
        Company company = companyRepository.findById(id).orElseThrow();
       return CompanyDto.builder()
               .id(company.getId())
               .name(company.getName())
               .email(company.getEmail())
               .numberPhone(company.getNumberPhone())
               .link(company.getLink())
               .categorys(company.getCategory())
               .isActive(company.isActive())
               .build();
    }

    public void editCompany(CompanyDto companyDto) {

        Company company = companyRepository.findById(companyDto.getId()).orElseThrow();

                company.setName(companyDto.getName());
                company.setEmail(companyDto.getEmail());
                company.setNumberPhone(companyDto.getNumberPhone());
                company.setLink(companyDto.getLink());
                company.setCategory(companyDto.getCategorys());
                company.setActive(companyDto.isActive());

        companyRepository.save(company);

    }

//    @Override
//    public void saveCompany(String name, String email, String numberPhone, String link, Category category) {
//        Company company = new Company();
//        company.setName(name);
//        company.setEmail(email);
//        company.setNumberPhone(numberPhone);
//        company.setLink(link);
//        company.setCategory(category);
//        companyRepository.save(company);
//    }
}

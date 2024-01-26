package com.hollannikas.water.architecture;

import com.hollannikas.water.annotations.DomainEntity;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.stereotype.Component;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@AnalyzeClasses(packages = "com.hollannikas.water")
public class CleanArchitectureTest {

    @ArchTest
    ArchRule use_cases_should_be_in_use_case_package = classes()
                .that()
                .haveSimpleNameEndingWith("UseCase")
                .should()
                .resideInAPackage("com.hollannikas.water.domain.usecase")
                .because("Use cases are the core of the business functionality");

    @ArchTest
    ArchRule use_case_entities_should_not_be_components = classes()
            .that()
            .resideInAPackage("com.hollannikas.water.domain.entity")
            .should()
            .notBeAnnotatedWith(Component.class)
            .because("These are not database entities");

    @ArchTest
    ArchRule only_inwards = layeredArchitecture()
            .consideringOnlyDependenciesInLayers()
            .layer("Domain model").definedBy("com.hollannikas.water.domain.entity")
            .layer("Use cases").definedBy("com.hollannikas.water.domain.usecase")
            .layer("Gateways").definedBy("com.hollannikas.water.controller..")
            .whereLayer("Domain model").mayNotAccessAnyLayer()
            .whereLayer("Use cases").mayOnlyAccessLayers("Domain model")
            .whereLayer("Gateways").mayOnlyAccessLayers("Domain model", "Use cases")
            .because("Policies should not affect mechanisms");

    @ArchTest
    ArchRule domain_entities_are_annotated = classes()
            .that()
            .resideInAPackage("com.hollannikas.water.domain.entity")
            .should()
            .beAnnotatedWith(DomainEntity.class)
            .because("They can easily be confused with hibernate entities");
 }

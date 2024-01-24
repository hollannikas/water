package com.hollannikas.water.architecture;

import com.hollannikas.water.annotations.DataEntity;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.stereotype.Component;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;


@AnalyzeClasses(packages = "com.hollannikas.water")
public class CleanArchitectureTest {

    @ArchTest
    public static final ArchRule use_cases_should_be_in_use_case_package = classes()
                .that()
                .haveSimpleNameEndingWith("UseCase")
                .should()
                .resideInAPackage("com.hollannikas.water.usecase")
                .because("Use cases are the core of the business functionality");

    @ArchTest
    public static final ArchRule use_case_entities_should_not_be_components = classes()
            .that()
            .resideInAPackage("com.hollannikas.water.entity")
            .should()
            .notBeAnnotatedWith(Component.class)
            .because("These are not database entities");

    @ArchTest
    public static final ArchRule only_inwards = layeredArchitecture()
            .consideringOnlyDependenciesInLayers()
            .layer("Domain model").definedBy("com.hollannikas.water.entity")
            .layer("Use cases").definedBy("com.hollannikas.water.usecase..")
            .layer("Gateways").definedBy("com.hollannikas.water.gateway..")
            .whereLayer("Domain model").mayNotAccessAnyLayer()
            .whereLayer("Use cases").mayOnlyAccessLayers("Domain model")
            .whereLayer("Gateways").mayOnlyAccessLayers("Domain model", "Use cases")
            .because("Policies should not affect mechanisms");

    @ArchTest
    public static final ArchRule data_access_objects_are_annotated = classes()
            .that()
            .resideInAPackage("com.hollannikas.water.gateway.persistence.repository.entity")
            .should()
            .beAnnotatedWith(DataEntity.class)
            .because("They can easily be confused with domain entities");


 }

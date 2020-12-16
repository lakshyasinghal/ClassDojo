package com.classDojo.codeGenerator.jooq;

import org.jooq.meta.jaxb.Configuration;
import org.jooq.meta.jaxb.Database;
import org.jooq.meta.jaxb.Generator;
import org.jooq.meta.jaxb.Jdbc;
import org.jooq.meta.jaxb.Target;

public class POJOGenerator {

	public static void main(String[] args) throws Exception {
		POJOGenerator generator = new POJOGenerator();
		generator.generate();
	}

	private void generate() throws Exception {
		Configuration config = configure();
		org.jooq.codegen.GenerationTool.generate(config);
	}

	Configuration configure() {
		return new Configuration()
				// Configure the database connection here
				.withJdbc(new Jdbc().withDriver("com.mysql.jdbc.Driver")
						.withUrl("jdbc:mysql://localhost:3306/ClassDojo").withUser("root").withPassword("root"))
				.withGenerator(new Generator()
						.withDatabase(new Database().withName("org.jooq.meta.mysql.MySQLDatabase").withIncludes(".*")
								.withExcludes("").withInputSchema("ClassDojo"))
						.withTarget(new Target().withPackageName("com.classDojo.entities.meta")
								.withDirectory("/home/lakshya/Tech/Apps/ClassDojo/server/src/main/java/entities")));
	}
}

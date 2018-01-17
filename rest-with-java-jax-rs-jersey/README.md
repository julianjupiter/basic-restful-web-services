# Notes for JPA
By default, this application is using EclipseLink JPA implementation:

The dependencies for pom.xml:
```
<!-- JPA : EclipseLink -->
<dependency>
	<groupId>org.eclipse.persistence</groupId>
		<artifactId>org.eclipse.persistence.jpa</artifactId>
		<version>2.7.1</version>
</dependency>
<!-- JPA : Hibernate -->
<!-- <dependency>
	<groupId>org.eclipse.persistence</groupId>
	<artifactId>javax.persistence</artifactId>
	<version>2.2.0</version>
</dependency>
<dependency>
	<groupId>org.hibernate</groupId>
	<artifactId>hibernate-core</artifactId>
	<version>5.2.12.Final</version>
	<exclusions>
    	<exclusion>
        	<groupId>org.hibernate.javax.persistence</groupId>
            <artifactId>hibernate-jpa-2.1-api</artifactId>
        </exclusion>
	</exclusions>
</dependency> -->
```

The persistence.xml:
```
<!-- JPA: EclipseLink -->
<persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence
             http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd"
             version="2.1">
	
	<persistence-unit name="basicrest">
		<provider>org.eclipse.persistence.jpa.PersistenceProvider</provider>
		<exclude-unlisted-classes>false</exclude-unlisted-classes>
		<properties>
			<property name="javax.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver"/>
			<property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/basicrest"/>
			<property name="javax.persistence.jdbc.user" value="root"/>
			<property name="javax.persistence.jdbc.password" value="admin"/>
		</properties>
	</persistence-unit>
</persistence>

<!-- JPA: Hibernate -->
<!-- <persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence"
			xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence
         http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd"
         version="2.1">

	<persistence-unit name="basicrest">
		<provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
	   <properties>
			<property name="javax.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver"/>
	      <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/basicrest"/>
	      <property name="javax.persistence.jdbc.user" value="root"/>
	      <property name="javax.persistence.jdbc.password" value="admin"/>
	
			<property name="hibernate.dialect" value="org.hibernate.dialect.MySQL5Dialect"/>
	      <property name="hibernate.show_sql" value="true"/>
	      <property name="hibernate.hbm2ddl.auto" value="update"/>
		</properties>
	</persistence-unit>
</persistence> -->
```

If Hibernate will be used instead of EclipseLink, comment out dependencies and persistence configuration for EclipseLink and uncomment those for Hibernate.
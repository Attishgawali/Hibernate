# Hibernate
Core Hibernate 
Here's an elaborate explanation of Hibernate:

1. What is Hibernate?
Hibernate is an open-source, lightweight, and high-performance ORM framework developed to bridge the gap between Java applications and relational databases. ORM stands for Object-Relational Mapping, which means it maps Java objects to database tables and vice versa, allowing developers to work with Java objects directly instead of writing raw SQL queries.

2. Why use Hibernate?
Hibernate offers several advantages that make it a preferred choice for database access in Java applications:

Productivity: By abstracting the database access layer, Hibernate eliminates the need to write complex SQL queries, which saves development time and effort.
Portability: With Hibernate, the application becomes database-independent, meaning you can switch databases (e.g., from MySQL to Oracle) with minimal code changes.
Performance: Hibernate optimizes database operations, reducing the need for manual tuning. It employs caching and lazy loading to retrieve data efficiently.
Maintainability: By keeping the database schema definition within the Java code (using annotations or XML mappings), Hibernate makes it easier to manage and version the data model.
Security: Hibernate handles SQL injection attacks by automatically sanitizing inputs.

3. How does Hibernate work?
Hibernate works by mapping Java objects to database tables and vice versa through metadata. The primary components of Hibernate are:

POJO (Plain Old Java Objects): These are regular Java classes representing entities (database tables) that need to be persisted in the database. These classes should follow certain conventions or be annotated with Hibernate-specific annotations.

Hibernate Configuration: A configuration file (usually XML or Java-based) that specifies the database connection details and other configurations for Hibernate.

SessionFactory: This is a heavyweight object responsible for creating and managing connections to the database. It is typically created once during the application's startup and shared across the application.

Session: A short-lived object that represents a single unit of work with the database. It provides methods to perform CRUD (Create, Read, Update, Delete) operations on entities.

Transactions: Hibernate supports transactions to maintain data consistency and integrity. Transactions are managed through the Session object.

Mapping Metadata: Hibernate uses mapping metadata (annotations or XML) to define the relationships between Java entities and database tables. These mappings define how fields in entities correspond to columns in tables.

HQL (Hibernate Query Language): HQL is a powerful object-oriented query language similar to SQL. However, instead of operating on database tables, it operates on Java objects and their properties.

4. Basic Steps to Use Hibernate:
   - Configure Hibernate by providing the database connection details and other properties.
   - Define the entity classes and annotate them with appropriate Hibernate annotations or use XML mappings.
   - Create a SessionFactory from the configuration, which is a heavyweight object that manages database connections.
   - Open a Session from the SessionFactory to perform database operations.
   - Use HQL or Criteria API to query, insert, update, or delete data from the database using Java objects.

Overall, Hibernate simplifies the process of interacting with relational databases in Java applications, providing a robust and efficient ORM solution. Its flexibility, ease of use, and support for various database vendors have made it a popular choice among Java developers for many years.



CONFIGURATION OF HIBERNATE OT JAVA PROGRAM

Configuring Hibernate in a Java program involves several steps. Below is a step-by-step guide on how to configure Hibernate in a Java program:

1.Set Up Your Project:
Start by creating a new Java project using your favorite IDE (e.g., Eclipse, IntelliJ) or build tool (e.g., Maven, Gradle). Make sure to include the necessary libraries for Hibernate, the database driver you intend to use, and any other dependencies.

2.Add Hibernate Configuration File:
Create a Hibernate configuration file, usually named hibernate.cfg.xml or hibernate.properties. This file will contain various configuration settings for Hibernate. Below is an example of hibernate.cfg.xml:

3.Create Entity Classes:
Define your entity classes that correspond to the database tables you want to interact with. These classes should be annotated with appropriate Hibernate annotations or provided with XML mappings. For example:

4.Initialize SessionFactory:
In your Java program, initialize the Hibernate SessionFactory using the configuration file. The SessionFactory is a heavyweight object and should be created once during the application's startup and reused throughout the application's lifecycle.

5.Perform Database Operations:
Now that you have set up Hibernate and the SessionFactory, you can start using it to perform database operations (CRUD) on your entity classes.


ALL COMMONLY USE ANNOTATION

1.@Entity:
The @Entity annotation is used to mark a Java class as an entity, representing a table in the database. An entity class must have this annotation, and its name will be used as the default table name unless explicitly specified. Entities are persistent and managed by Hibernate.

2.@Id:
The @Id annotation is used to mark a field as the primary key of the entity. It is typically used in conjunction with one of the generation strategy annotations (@GeneratedValue) to define how the primary key values are generated (e.g., auto-increment, sequence).

3.@GeneratedValue:
The @GeneratedValue annotation is used in conjunction with @Id to specify the strategy for generating primary key values. There are different strategies, such as GenerationType.IDENTITY, GenerationType.AUTO, and GenerationType.SEQUENCE.

4.@Column:
The @Column annotation is used to map a field to a database column. It allows you to specify various attributes of the column, such as name, length, nullable, and unique.

5.@Table:
The @Table annotation is used to specify the details of the database table that an entity is mapped to. You can use it to define the table name, schema, and additional options.

6.@Transient:
The @Transient annotation is used to mark a field that should not be persisted in the database. Hibernate will ignore such fields during the persistence process.

7.@OneToMany and @ManyToOne:
These annotations are used to specify one-to-many and many-to-one relationships between entities, respectively. For example, if an entity "A" has a one-to-many relationship with entity "B," you would use @OneToMany in "A" and @ManyToOne in "B" to establish the association.

8.@ManyToMany:
The @ManyToMany annotation is used to specify a many-to-many relationship between entities. It involves creating an association table in the database to hold the relationships.

9.@JoinColumn:
The @JoinColumn annotation is used to define the foreign key column when mapping associations between entities. It allows you to specify the column name, nullable, and other properties.



FETCHING DATA FROM DATABASE UNSING GET AND LOAD METHOD
1.get() method:
The get() method is used to retrieve an entity from the database based on its primary key. If the entity with the given primary key exists in the database, get() returns the corresponding Java object (entity). If the entity does not exist, get() returns null.
   entityClass: The Java class representing the entity you want to fetch.
   id: The primary key value of the entity you want to retrieve.

   It's important to note that if get() is called with a non-existent primary key value, it will return null without throwing any exception. If your application expects an entity to exist and you need to handle the case when it doesn't, consider using load() instead.

2.load() method:
The load() method is also used to fetch an entity based on its primary key, but it behaves differently compared to get(). When you call load(), Hibernate does not immediately hit the database to retrieve the entity. Instead, it returns a "proxy" object, which is a placeholder for the actual entity.
The proxy object is a lightweight object with the same identifier as the requested entity. It contains just enough information to fetch the actual entity from the database when you access its properties or methods.
   entityClass: The Java class representing the entity you want to fetch.
   id: The primary key value of the entity you want to retrieve.

   It's important to note that if the entity with the given primary key does not exist in the database and you try to access its properties or methods, a org.hibernate.ObjectNotFoundException will be thrown.



EMBEDDING OBJECT
In Hibernate, "embedding objects" refers to the process of persisting and mapping complex objects as part of an entity's attributes. These complex objects are not separate entities with their own tables in the database but are considered as an integral part of the entity they belong to. Embedding objects is achieved using the @Embeddable and @Embedded annotations in Hibernate.




RELATIONAL MAPPING 
1. ONE-TO-ONE MAPPING
   In Hibernate, the One-to-One mapping is used to define a relationship between two entities, where one entity is associated with exactly one instance of another entity. This means that for every record in one table, there can be only one matching record in the associated table. One-to-One relationships can be unidirectional or bidirectional, depending on whether the association is navigable from both entities or just one.
   
   One-to-One Unidirectional Mapping:
In a unidirectional One-to-One relationship, one entity has a reference to another entity, but the other entity does not have a reference

   One-to-One Bidirectional Mapping:
In a bidirectional One-to-One relationship, both entities have references to each other. This is achieved by using the mappedBy attribute in the @OneToOne annotation to specify the inverse side of the relationship.


2.ONE-TO-MANY MAPPPING

   Unidirectional One-to-Many Relationship:
In a unidirectional One-to-Many relationship, one entity (parent) is associated with multiple instances of another entity (child), but the child entity does not have a direct reference back to the parent entity. This is achieved using the @OneToMany annotation in Hibernate.

   Bidirectional One-to-Many Relationship:
In a bidirectional One-to-Many relationship, both entities have references to each other, allowing easy navigation from both ends. This is achieved using the @OneToMany and @ManyToOne annotations together in Hibernate.


3.MANY-TO-MANY
   In Hibernate, the Many-to-Many relationship is used to represent associations between two entities in which each entity can be associated with multiple instances of the other entity. This relationship is achieved using the @ManyToMany annotation. To implement a Many-to-Many relationship, an intermediate table, known as a "join table," is used to store the associations between the two entities.



FETCHING TECHNIQUE EAGER AND LAZY

In Hibernate, fetching refers to the process of retrieving associated entities (related objects) along with the main entity. The two common fetching strategies are EAGER and LAZY. These strategies dictate when and how related entities are loaded from the database.

EAGER Fetching:
In EAGER fetching, related entities are loaded immediately and eagerly with the main entity. When you retrieve the main entity, Hibernate will automatically fetch the associated entities from the database as well.

LAZY Fetching:
In LAZY fetching, related entities are not loaded immediately when the main entity is fetched. Instead, they are loaded from the database only when accessed explicitly in the code.
LAZY fetching can help improve performance by avoiding unnecessary database queries for related entities that may not be needed in a particular use case. It allows you to control when and which related entities should be loaded, helping to optimize database interactions.

Choosing between EAGER and LAZY fetching depends on your specific use case and performance requirements. In general, it's a good practice to use LAZY fetching by default and use EAGER fetching only when you are sure that you always need the related entities when querying the main entity. You can also use the fetch attribute of other fetch-related annotations like @OneToOne, @ManyToOne, or @ManyToMany to specify the fetching strategy for individual associations.



HIBERNATE CACHING
Caching in Hibernate refers to the mechanism of storing frequently accessed data in memory to improve application performance and reduce the number of database queries. Hibernate provides two levels of caching: Level 1 (Session-level) cache and Level 2 (SessionFactory-level) cache.

Level 1 Cache (Session-level cache):
Level 1 cache is associated with the Hibernate Session object and exists for the duration of a single session. It is enabled by default and stores the objects that have been read or written during the current session. When you fetch an entity from the database using a Hibernate Session, the entity is stored in the Level 1 cache. If you retrieve the same entity again within the same session, Hibernate will return the cached object instead of querying the database again.
The Level 1 cache is limited to a single session and doesn't support clustering or sharing across different sessions or application instances.

Level 2 Cache (SessionFactory-level cache):
Level 2 cache is shared across all sessions within the same SessionFactory and even across multiple application instances if you have a distributed cache. It helps to reduce the database load and improve performance by caching query results, entities, and collection data. Hibernate doesn't provide an implementation for Level 2 caching directly, but it allows you to integrate with various third-party caching providers like Ehcache, Hazelcast, or Infinispan.

Once you enable the Level 2 cache, Hibernate will automatically cache entities and query results in the configured cache provider. When you execute the same query multiple times or fetch the same entity from different sessions, Hibernate will check the Level 2 cache first before going to the database.

It's essential to configure the cache provider properly and choose the appropriate caching strategy (read-only, read-write, nonstrict-read-write, transactional) based on your application's requirements.

Caching in Hibernate is a powerful tool to improve application performance and reduce database round-trips. However, caching also introduces challenges like cache synchronization, cache invalidation, and managing stale data. Careful consideration and tuning are necessary to strike the right balance between caching benefits and potential complexities. Additionally, you should be cautious when using caching with entities that have complex relationships or frequently changing data to ensure data consistency.



HIBERNATE OBJECT STATE
In Hibernate, an object's state refers to its current status in relation to its persistence lifecycle and the associated database. Hibernate manages the lifecycle of objects and tracks their state changes to ensure that the object's state and the corresponding database state are synchronized. There are mainly three states an object can be in within the Hibernate context: Transient, Persistent, and Detached.

Transient State:
An object is in the transient state if it's just created using the new keyword and is not associated with any Hibernate Session. Transient objects are not yet managed by Hibernate, and they are not associated with any database row. These objects are outside the scope of Hibernate's persistence management.

Persistent State:
An object is in the persistent state when it's associated with a Hibernate Session and is being managed by Hibernate for persistence. In this state, Hibernate tracks changes made to the object's properties and automatically synchronizes those changes with the database when the transaction is committed. An object transitions from the transient state to the persistent state when it's saved or persisted using the save, persist, or update methods.

Detached State:
An object is in the detached state when it was once associated with a Hibernate Session but is no longer managed by that session. This can happen when the session is closed or when the object is explicitly detached using the evict or clear methods of the Session. Detached objects are still persistent, meaning they have a corresponding database record. However, changes made to detached objects are not automatically synchronized with the database.

Understanding and managing the object's state is crucial when working with Hibernate. You need to be aware of when objects transition between these states to ensure that your data is consistent and accurate in the database. Hibernate provides methods and mechanisms to handle these state transitions effectively, allowing you to perform CRUD (Create, Read, Update, Delete) operations on your entities seamlessly.

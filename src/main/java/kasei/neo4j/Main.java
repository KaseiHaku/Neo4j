package kasei.neo4j;

import org.neo4j.common.DependencyResolver;
import org.neo4j.configuration.GraphDatabaseSettings;
import org.neo4j.configuration.connectors.BoltConnector;
import org.neo4j.configuration.connectors.HttpConnector;
import org.neo4j.configuration.helpers.SocketAddress;
import org.neo4j.configuration.ssl.SslPolicyConfig;
import org.neo4j.dbms.api.DatabaseManagementService;
import org.neo4j.dbms.api.DatabaseManagementServiceBuilder;
import org.neo4j.dbms.api.DatabaseNotFoundException;
import org.neo4j.exceptions.UnsatisfiedDependencyException;
import org.neo4j.graphdb.*;
import org.neo4j.graphdb.config.Setting;
import org.neo4j.kernel.impl.security.URLAccessRules;
import org.neo4j.logging.Log;
import org.neo4j.logging.LogProvider;

import java.io.File;
import java.time.Duration;
import java.util.function.Supplier;

public class Main {



    public static void main(String[] args) {

        File dbHomeDir = new File("src/main/resources/neo4j");
        DatabaseManagementService managementService = new DatabaseManagementServiceBuilder(dbHomeDir)
                /** TODO 默认库 neo4j 不需要认证 */
                // .setConfig(GraphDatabaseSettings.auth_enabled, true)
                // .setConfig(GraphDatabaseSettings.auth_max_failed_attempts, 3)
                // .setConfig(GraphDatabaseSettings.auth_lock_time, Duration.ofMinutes(2))
                .setConfig(GraphDatabaseSettings.read_only, false)
                // .setConfig(GraphDatabaseSettings.pagecache_memory, "512M")
                // .setConfig(GraphDatabaseSettings.string_block_size, 60)
                // .setConfig(GraphDatabaseSettings.array_block_size, 300)

                /** TODO bolt:// 连接协议配置
                 * 连接串： jdbc:neo4j:bolt://localhost:7687/
                 * 默认用户名： neo4j
                 * 默认密码： neo4j
                 */
                .setConfig(BoltConnector.enabled, true)
                .setConfig(BoltConnector.listen_address, new SocketAddress("localhost", 7687))
                .setConfig(BoltConnector.thread_pool_max_size, 8)

                // TODO http:// 连接协议配置
                // .setConfig(HttpConnector.enabled, true)
                // .setConfig(HttpConnector.listen_address,  new SocketAddress("localhost", 7474))

                // TODO TLS 配置
                // .setConfig(SslPolicyConfig.forScope(), 8)

                .build();
        registerShutdownHook( managementService );

        GraphDatabaseService graphDb = managementService.database(GraphDatabaseSettings.DEFAULT_DATABASE_NAME);

        try ( Transaction tx = graphDb.beginTx() ) {
            // Database operations go here
            Node firstNode = tx.createNode();
            firstNode.setProperty( "message", "Hello, " );
            Node secondNode = tx.createNode();
            secondNode.setProperty( "message", "World!" );


            Relationship relationship = firstNode.createRelationshipTo(secondNode, RelTypes.KNOWS);
            relationship.setProperty( "message", "brave Neo4j " );


            System.out.print( firstNode.getProperty( "message" ) );
            System.out.print( relationship.getProperty( "message" ) );
            System.out.print( secondNode.getProperty( "message" ) );


            // firstNode = tx.getNodeById( firstNode.getId() );
            // secondNode = tx.getNodeById( secondNode.getId() );
            // firstNode.getSingleRelationship( RelTypes.KNOWS, Direction.OUTGOING ).delete();
            // firstNode.delete();
            // secondNode.delete();

            tx.commit();
        }


        // managementService.shutdown();
    }


    private static void registerShutdownHook( final DatabaseManagementService managementService )    {
        // Registers a shutdown hook for the Neo4j instance so that it
        // shuts down nicely when the VM exits (even if you "Ctrl-C" the
        // running application).
        Runtime.getRuntime().addShutdownHook( new Thread() {
                @Override
                public void run()            {
                    managementService.shutdown();
                }
            }
        );
    }
}

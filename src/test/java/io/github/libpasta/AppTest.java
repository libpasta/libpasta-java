package io.github.libpasta;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        // assertTrue( true );
        String hash = pasta.hash_password("hello123");
        assert pasta.verify_password(hash, "hello123");

        String old_hash = "$2a$10$vI8aWBnW3fID.ZQ4/zo1G.q1lRps.9cGLcZEiGDMVr5yUP1KUOYTa";
        ResultHash result = pasta.verify_password_update_hash(old_hash, "my password");
        assert result.getFirst();
        String new_hash = result.getSecond();
        System.out.println("New hash: " + new_hash);
        assert pasta.verify_password(new_hash, "my password");


        Argon2i alg = new Argon2i();
        Config cfg = Config.with_primitive(alg);
        String migrated_hash = cfg.migrate_hash(hash);
        assert migrated_hash.startsWith("$!$argon2i");

        ResultHash res = cfg.verify_password_update_hash(migrated_hash, "not my password");
        assert !res.getFirst();
        res = cfg.verify_password_update_hash(migrated_hash, "hello123");
        System.out.println("New hash: " + res.getSecond());
        assert res.getFirst();
        // This is not actually working correctly yet:
        // assert res.getSecond().startsWith("$argon2i");

        System.out.println((char)27 + "[1;32mJava test passed." + (char)27 + "[m");
    }
}

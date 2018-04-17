package io.aamzerin.springherotour.domain;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Tailable;

public interface HeroRepository extends MongoRepository<Hero, String> {

	/**
	 * String query selecting one entity.
	 *
	 * @param lastname
	 * @return
	 */
	@Query("{ 'id': ?0, 'name': ?1}")
	Hero findByIdAndNameQuery(String firstname, String lastname);
	
	/**
	 * String query selecting one entity.
	 *
	 * @param lastname
	 * @return
	 */
	@Query("{ 'id': ?0}")
	Hero findById(Integer id);

	/**
	 * Derived query selecting by {@code lastname}. {@code lastname} uses deferred resolution that does not require
	 * blocking to obtain the parameter value.
	 *
	 * @param lastname
	 * @return
	 */
	List<Hero> findByName(String name);
	
	/**
	 * Derived query selecting by {@code lastname}. {@code lastname} uses deferred resolution that does not require
	 * blocking to obtain the parameter value.
	 *
	 * @param lastname
	 * @return
	 */
	@Query("{'name': {$regex: ?0, $options : 'i' }})")
    List<Hero> findByNameTerm(String name);

	/**
	 * Derived query selecting by {@code firstname} and {@code lastname}. {@code firstname} uses deferred resolution that
	 * does not require blocking to obtain the parameter value.
	 *
	 * @param firstname
	 * @param lastname
	 * @return
	 */
	List<Hero> findByIdAndName(Integer integer, String name);

	/**
	 * Use a tailable cursor to emit a stream of entities as new entities are written to the capped collection.
	 *
	 * @return
	 */
	@Tailable
	List<Hero> findWithTailableCursorBy();
	
	/**
	 * String query deleting one entity.
	 *
	 * @param id
	 * @return
	 */
	@Query(value = "{ 'id': ?0}", delete = true)
	Long deleteById(Integer id);

}

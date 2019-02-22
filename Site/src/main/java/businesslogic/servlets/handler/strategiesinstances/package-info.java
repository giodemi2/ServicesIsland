/**
 * 
 */
/**
 * @author rodolfo
 * This package contains a singleton class with
 * all Strategy instances.
 * It is useful becuse when we make a lot of
 * request the server make several time a lot
 * of new {@link businesslogic.servlets.handler.Strategy}
 * subclasses.
 * It is bad fot memory!
 */
package businesslogic.servlets.handler.strategiesinstances;
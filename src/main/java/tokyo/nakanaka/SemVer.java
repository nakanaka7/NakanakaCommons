package tokyo.nakanaka;

/**
 * A record which holds semantic version component numbers.
 * @param major Major number
 * @param minor Minor number
 * @param patch Patch number
 */
public record SemVer(int major, int minor, int patch) {

}

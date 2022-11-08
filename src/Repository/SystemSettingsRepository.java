package Repository;

import Entity.SystemSettings;
/**
 * Repository that encapsulate the logic required to access the data sources for system settings.
 * 
 */
public class SystemSettingsRepository extends Repository<SystemSettings> {

    public SystemSettingsRepository(String fileName) {
        super(fileName);
    }

}
package lol.suicide.uber.utilities;

import com.google.common.collect.Lists;
import net.minecraft.server.v1_8_R3.EntityInsentient;
import net.minecraft.server.v1_8_R3.EntityTypes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

public class NMSUtils {

    public static void registerEntity(final String name, final int id, final Class<? extends EntityInsentient> nmsClass,
                                      final Class<? extends EntityInsentient> customClass) {
        try {

            final List<Map<?, ?>> dataMaps = Lists.newArrayList();
            for (final Field f : EntityTypes.class.getDeclaredFields()) {
                if (f.getType().getSimpleName().equals(Map.class.getSimpleName())) {
                    f.setAccessible(true);
                    dataMaps.add((Map<?, ?>) f.get(null));
                }
            }

            if (dataMaps.get(2).containsKey(id)) {
                dataMaps.get(0).remove(name);
                dataMaps.get(2).remove(id);
            }

            final Method method = EntityTypes.class.getDeclaredMethod("a", Class.class, String.class, int.class);
            method.setAccessible(true);
            method.invoke(null, customClass, name, id);

        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
}

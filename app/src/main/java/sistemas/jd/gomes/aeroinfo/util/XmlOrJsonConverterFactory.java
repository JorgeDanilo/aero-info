package sistemas.jd.gomes.aeroinfo.util;

import com.google.gson.GsonBuilder;

import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import androidx.annotation.Nullable;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class XmlOrJsonConverterFactory extends Converter.Factory {

    @Nullable
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(
            Type type,
            Annotation[] annotations,
            Retrofit retrofit
    ) {
        for (Annotation annotation : annotations) {
            if (annotation.annotationType() == Xml.class) {
                return SimpleXmlConverterFactory.createNonStrict(
                        new Persister(new AnnotationStrategy()))
                        .responseBodyConverter(type, annotations, retrofit);
            }
            if (annotation.annotationType() == Json.class) {
                return GsonConverterFactory.create(
                        new GsonBuilder().create()).responseBodyConverter(type, annotations, retrofit);
            }
        }

        return GsonConverterFactory.create(
                new GsonBuilder().create()).responseBodyConverter(type, annotations, retrofit);
    }
}

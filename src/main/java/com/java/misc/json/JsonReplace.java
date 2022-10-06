package com.java.misc.json;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.misc.models.OutraClasse;

public class JsonReplace {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {

		String json = "{\r\n" + "  \"auth\": {\r\n"
				+ "    \"Usuario\": \"{{TbWebServiceProxyConfigModel.usuario}}\",\r\n"
				+ "    \"Senha\": {{TbWebServiceProxyConfigModel.senha}},\r\n"
				+ "    \"CodigoParametro\": {{TbWebServiceProxyConfigModel.codigoParametro}},\r\n"
				+ "    \"Chave\": {{TbWebServiceProxyConfigModel.chave}}\r\n" + "  },\r\n" + "  \"dto\": {\r\n"
				+ "    \"CodigoProposta\": {{FidcTransacaoModel.retornoCodigoProposta}},\r\n"
				+ "    \"CodigoOperacao\": {{FidcTransacaoModel.codigoOperacao}}\r\n" + "  },\r\n"
				+ "  \"textoMotivoCancelamento\": \"DESIST??NCIA DO CLIENTE\"\r\n" + "}";

//	    ObjectMapper objectMapper = new ObjectMapper();
//	    final var pessoa = objectMapper.
//	    System.out.println(pessoa);
		
		String toReplace = "{{TbWebServiceProxyConfigModel.usuario}}";
		toReplace = toReplace.replace("{{","").replace("}}", "");
		String parts [] = toReplace.split("\\.");
		System.out.println(parts);

		List<String> allMatches = new ArrayList<String>();

		String regex = "\\{{2}[A-Za-z]\\w+\\.[A-Za-z]\\w+\\}{2}";

		Matcher m = Pattern.compile(regex).matcher(json);

		while (m.find()) {
			allMatches.add(m.group());
		}

		OutraClasse oc1 = new OutraClasse();
		oc1.setId(1);
		oc1.setAge(18);
		oc1.setName("Eduard");

		Class outraClasseB = oc1.getClass();

		Class classOutra = Class.forName("com.java.misc.models.OutraClasse");

		Class classC = OutraClasse.class;

		/*
		 * INICIO
		 * JAVA REFLECTION
		 * */
		// create an object of Dog
//		OutraClasse oc1 = new OutraClasse();

		// create an object of Class
		// using getClass()
		Class obj = oc1.getClass();

		// access and set the type field
		String name = "name";
		Field field1 = obj.getField(name);
//		Field field1 = obj.getField("name");
//		field1.set(oc1, "labrador");

		// get the value of the field type
		String typeValue = (String) field1.get(oc1);
		System.out.println("VALOR: " + typeValue);
		
		/*
		 * FIM DO JAVA REFLECTION
		 * */

		// get the access modifier of the field type
		int mod = field1.getModifiers();

		// convert the modifier to String form
		String modifier1 = Modifier.toString(mod);
		System.out.println("Modifier: " + modifier1);
		System.out.println(" ");
		
		

		Class<OutraClasse> classe = OutraClasse.class;
		for (Field atributo : classe.getDeclaredFields()) {
			System.out.println(atributo.getName());
		}

//		Class<"OutraClasse"> myClass = "OutraClasse".getClass();

		for (String valueReplace : allMatches) {
			json = json.replace(valueReplace, "NOVO VALOR");
		}
		// System.out.println(json);

		Object arquivoFromReflection = null;
		try {
			arquivoFromReflection = Class.forName("com.java.misc.models.OutraClasse").newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("Nome da Classe: " + arquivoFromReflection.getClass().getName());

		System.out.println("");
		System.out.println("Métodos: ");
		for (Method method : arquivoFromReflection.getClass().getMethods()) {
			System.out.print(method.getName() + ", ");
		}

		System.out.println("");
		System.out.println("Atributos: ");
		for (Field f : arquivoFromReflection.getClass().getDeclaredFields()) {
			System.out.print(f.getName() + ", ");
		}

//		String stringToSearch = "Four score and seven years ago our fathers ...";
//
//		Pattern pat = Pattern.compile(" (\\S+or\\S+) "); // the pattern to search for
//		Matcher mat = pat.matcher(stringToSearch);
//
//		// if we find a match, get the group
//		if (mat.find()) {
//
//			allMatches.add(mat.group());
//
//			// String theGroup = mat.group(2);
//
//			// print the group out for verification
//			// System.out.format("'%s'\n", theGroup);
//			System.out.println(allMatches);
//		}

	}

}

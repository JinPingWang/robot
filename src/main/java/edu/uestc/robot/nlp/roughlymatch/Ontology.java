package edu.uestc.robot.nlp.roughlymatch;

import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.iterator.ExtendedIterator;

import java.io.InputStream;
import java.util.HashSet;

/**
 * Created by yb on 2016/7/4 0004.
 */
public class Ontology {
    private HashSet<String> ontologies;
    public Ontology() {
    }

    public Ontology(HashSet<String> ontologies) {
        this.ontologies = ontologies;
    }

    public Ontology(String path) {
        ontologies = new HashSet<String>();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(path);
        OntModel model = ModelFactory.createOntologyModel();
        model.read(inputStream, "");
        ExtendedIterator<OntClass> iterator = model.listClasses();
        while(iterator.hasNext()) {
            OntClass ontClass = iterator.next();
            if (!ontClass.isAnon()) {
                ontologies.add(ontClass.getLocalName());
            }
        }
    }
    public HashSet<String> getOntologies() {
        return ontologies;
    }

    public void setOntologies(HashSet<String> ontologies) {
        this.ontologies = ontologies;
    }

    public Boolean isOntology(String name) {
        return !"".equals(name) && ontologies.contains(name);
    }

}

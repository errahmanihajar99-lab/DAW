<?xml version="1.0" encoding="ISO-8859-1"?>
<!-- Déclaration XML standard  
    - version = XML 1.0  
    - encoding = type de caractères-->

<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
    <!-- Le point de départ 
        - xsl:template = une règle de transformation
        - `match="/"` = “commence à la racine du XML”  -->  
      
        <Departments><!-- Elle sert de conteneur (racine du résultat) -->
            <xsl:for-each select="//Department">
            <!-- C’est une boucle qui parcourt tous les éléments <Department> dans tout le document. -->

                <Title>
                    <xsl:value-of select="Title"/>
                    <!-- prend le texte du nœud <Title> et l’insère dans le résultat. -->
                </Title>
            </xsl:for-each>
        </Departments>
    </xsl:template>

</xsl:stylesheet>
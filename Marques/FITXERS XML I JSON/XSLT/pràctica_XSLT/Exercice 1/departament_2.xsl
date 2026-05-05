<?xml version="1.0" encoding="ISO-8859-1"?>

<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <Departments>
            <xsl:for-each select="//Department">
                <Department>
                        <Title>
                        <xsl:value-of select="Title"/>
                    </Title>
                    <Chair>
                        <xsl:copy-of select="Chair"/>
                    </Chair>
                </Department>    
            </xsl:for-each>
        </Departments>
    </xsl:template>
</xsl:stylesheet>
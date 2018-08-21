package org.sackfix.fix50sp1modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.modified.xml
  */
case class LinesOfTextGrpComponent(noLinesOfTextField:NoLinesOfTextField,
                                   linesOfTextGroups: List[LinesOfTextGroup]) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noLinesOfTextField.value != linesOfTextGroups.size)
    throw SfRepeatingGroupCountException(NoLinesOfTextField.TagId,noLinesOfTextField.value, linesOfTextGroups.size)

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,noLinesOfTextField)
    b
  }

}
     
object LinesOfTextGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int](
    NoLinesOfTextField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    LinesOfTextGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int]()

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    LinesOfTextGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    LinesOfTextGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoLinesOfTextField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = LinesOfTextGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[LinesOfTextGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(LinesOfTextGrpComponent(NoLinesOfTextField.decode(myFields.get(NoLinesOfTextField.TagId)).get,
        if (nextTagPosLookup.contains(NoLinesOfTextField.TagId)) LinesOfTextGroup.decode(flds, nextTagPosLookup(NoLinesOfTextField.TagId)).get else List.empty))
    } else None
  }

    
}
     
package org.sackfix.fix50

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50.xml
  */
case class InstrmtStrkPxGrpComponent(noStrikesField:NoStrikesField,
                                     strikesGroups: List[StrikesGroup]) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noStrikesField.value != strikesGroups.size)
    throw SfRepeatingGroupCountException(NoStrikesField.TagId,noStrikesField.value, strikesGroups.size)

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,noStrikesField)
    b
  }

}
     
object InstrmtStrkPxGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int](
    NoStrikesField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    StrikesGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int]()

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    StrikesGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    StrikesGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoStrikesField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = StrikesGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[InstrmtStrkPxGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(InstrmtStrkPxGrpComponent(NoStrikesField.decode(myFields.get(NoStrikesField.TagId)).get,
        if (nextTagPosLookup.contains(NoStrikesField.TagId)) StrikesGroup.decode(flds, nextTagPosLookup(NoStrikesField.TagId)).get else List.empty))
    } else None
  }

    
}
     
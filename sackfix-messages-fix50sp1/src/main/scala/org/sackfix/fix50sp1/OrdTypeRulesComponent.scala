package org.sackfix.fix50sp1

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.xml
  */
case class OrdTypeRulesComponent(noOrdTypeRulesField:Option[NoOrdTypeRulesField]=None,
                                 ordTypeRulesGroups: Option[List[OrdTypeRulesGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noOrdTypeRulesField.map(_.value).getOrElse(0) != ordTypeRulesGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoOrdTypeRulesField.TagId,noOrdTypeRulesField.map(_.value).getOrElse(0), ordTypeRulesGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noOrdTypeRulesField.foreach(fmt(b,_))
    ordTypeRulesGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object OrdTypeRulesComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    OrdTypeRulesGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoOrdTypeRulesField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    OrdTypeRulesGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    OrdTypeRulesGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoOrdTypeRulesField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = OrdTypeRulesGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[OrdTypeRulesComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(OrdTypeRulesComponent(myFields.get(NoOrdTypeRulesField.TagId).flatMap(f=>NoOrdTypeRulesField.decode(f)),
        if (nextTagPosLookup.contains(NoOrdTypeRulesField.TagId)) OrdTypeRulesGroup.decode(flds, nextTagPosLookup(NoOrdTypeRulesField.TagId)) else None))
    } else None
  }

    
}
     
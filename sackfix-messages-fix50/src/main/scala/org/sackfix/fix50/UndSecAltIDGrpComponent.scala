package org.sackfix.fix50

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50.xml
  */
case class UndSecAltIDGrpComponent(noUnderlyingSecurityAltIDField:Option[NoUnderlyingSecurityAltIDField]=None,
                                   underlyingSecurityAltIDGroups: Option[List[UnderlyingSecurityAltIDGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noUnderlyingSecurityAltIDField.map(_.value).getOrElse(0) != underlyingSecurityAltIDGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoUnderlyingSecurityAltIDField.TagId,noUnderlyingSecurityAltIDField.map(_.value).getOrElse(0), underlyingSecurityAltIDGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noUnderlyingSecurityAltIDField.foreach(fmt(b,_))
    underlyingSecurityAltIDGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object UndSecAltIDGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    UnderlyingSecurityAltIDGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoUnderlyingSecurityAltIDField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    UnderlyingSecurityAltIDGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    UnderlyingSecurityAltIDGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoUnderlyingSecurityAltIDField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = UnderlyingSecurityAltIDGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[UndSecAltIDGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(UndSecAltIDGrpComponent(myFields.get(NoUnderlyingSecurityAltIDField.TagId).flatMap(f=>NoUnderlyingSecurityAltIDField.decode(f)),
        if (nextTagPosLookup.contains(NoUnderlyingSecurityAltIDField.TagId)) UnderlyingSecurityAltIDGroup.decode(flds, nextTagPosLookup(NoUnderlyingSecurityAltIDField.TagId)) else None))
    } else None
  }

    
}
     
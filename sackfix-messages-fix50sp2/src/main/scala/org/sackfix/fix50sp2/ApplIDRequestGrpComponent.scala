package org.sackfix.fix50sp2

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.xml
  */
case class ApplIDRequestGrpComponent(noApplIDsField:Option[NoApplIDsField]=None,
                                     applIDsGroups: Option[List[ApplIDsGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noApplIDsField.map(_.value).getOrElse(0) != applIDsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoApplIDsField.TagId,noApplIDsField.map(_.value).getOrElse(0), applIDsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noApplIDsField.foreach(fmt(b,_))
    applIDsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object ApplIDRequestGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    ApplIDsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoApplIDsField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    ApplIDsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    ApplIDsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoApplIDsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = ApplIDsGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[ApplIDRequestGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(ApplIDRequestGrpComponent(myFields.get(NoApplIDsField.TagId).flatMap(f=>NoApplIDsField.decode(f)),
        if (nextTagPosLookup.contains(NoApplIDsField.TagId)) ApplIDsGroup.decode(flds, nextTagPosLookup(NoApplIDsField.TagId)) else None))
    } else None
  }

    
}
     
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
case class NotAffectedOrdersGrpComponent(noNotAffectedOrdersField:Option[NoNotAffectedOrdersField]=None,
                                         notAffectedOrdersGroups: Option[List[NotAffectedOrdersGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noNotAffectedOrdersField.map(_.value).getOrElse(0) != notAffectedOrdersGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoNotAffectedOrdersField.TagId,noNotAffectedOrdersField.map(_.value).getOrElse(0), notAffectedOrdersGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noNotAffectedOrdersField.foreach(fmt(b,_))
    notAffectedOrdersGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object NotAffectedOrdersGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    NotAffectedOrdersGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoNotAffectedOrdersField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    NotAffectedOrdersGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    NotAffectedOrdersGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoNotAffectedOrdersField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = NotAffectedOrdersGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[NotAffectedOrdersGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(NotAffectedOrdersGrpComponent(myFields.get(NoNotAffectedOrdersField.TagId).flatMap(f=>NoNotAffectedOrdersField.decode(f)),
        if (nextTagPosLookup.contains(NoNotAffectedOrdersField.TagId)) NotAffectedOrdersGroup.decode(flds, nextTagPosLookup(NoNotAffectedOrdersField.TagId)) else None))
    } else None
  }

    
}
     
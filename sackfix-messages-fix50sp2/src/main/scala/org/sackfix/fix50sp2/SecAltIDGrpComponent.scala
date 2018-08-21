package org.sackfix.fix50sp2

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.xml
  */
case class SecAltIDGrpComponent(noSecurityAltIDField:Option[NoSecurityAltIDField]=None,
                                securityAltIDGroups: Option[List[SecurityAltIDGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noSecurityAltIDField.map(_.value).getOrElse(0) != securityAltIDGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoSecurityAltIDField.TagId,noSecurityAltIDField.map(_.value).getOrElse(0), securityAltIDGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noSecurityAltIDField.foreach(fmt(b,_))
    securityAltIDGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object SecAltIDGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    SecurityAltIDGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoSecurityAltIDField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    SecurityAltIDGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    SecurityAltIDGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoSecurityAltIDField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = SecurityAltIDGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SecAltIDGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(SecAltIDGrpComponent(myFields.get(NoSecurityAltIDField.TagId).flatMap(f=>NoSecurityAltIDField.decode(f)),
        if (nextTagPosLookup.contains(NoSecurityAltIDField.TagId)) SecurityAltIDGroup.decode(flds, nextTagPosLookup(NoSecurityAltIDField.TagId)) else None))
    } else None
  }

    
}
     